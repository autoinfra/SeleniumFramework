package utilities.customAnnotations.AzureDevOps;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AzureDevOpsIssue {
    int WorkItemID() default 0;
    int BudID() default 0;
}
