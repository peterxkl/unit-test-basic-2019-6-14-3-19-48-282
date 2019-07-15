package ExpenseService;

import ExpenseService.Exception.UnexpectedProjectTypeException;
import ExpenseService.Expense.ExpenseType;
import ExpenseService.Project.Project;
import ExpenseService.Project.ProjectType;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertSame;

class ExpenseServiceTest {
    @Test
    void should_return_internal_expense_type_if_project_is_internal() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(ProjectType.INTERNAL,"Project A");

        // when
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        assertSame(ExpenseType.INTERNAL_PROJECT_EXPENSE,expenseType);
    }

    @Test
    void should_return_expense_type_A_if_project_is_external_and_name_is_project_A() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(ProjectType.EXTERNAL,"Project A");
        // when
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        assertSame(ExpenseType.EXPENSE_TYPE_A,expenseType);
    }

    @Test
    void should_return_expense_type_B_if_project_is_external_and_name_is_project_B() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(ProjectType.EXTERNAL,"Project B");
        // when
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        assertSame(ExpenseType.EXPENSE_TYPE_B,expenseType);
    }

    @Test
    void should_return_other_expense_type_if_project_is_external_and_has_other_name() throws UnexpectedProjectTypeException {
        // given
        Project project = new Project(ProjectType.EXTERNAL,"Project C");
        // when
        ExpenseType expenseType = ExpenseService.getExpenseCodeByProjectTypeAndName(project);
        // then
        assertSame(ExpenseType.OTHER_EXPENSE,expenseType);

    }

    @Test
    void should_throw_unexpected_project_exception_if_project_is_invalid() {
        // given
        // when
        // then
    }
}