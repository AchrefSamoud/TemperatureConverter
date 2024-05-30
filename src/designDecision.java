import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface designDecision {
    String[] fragmentsNames(); // Add an array of fragment names
}
