package annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE) //The marked annotation is retained in the source level and is ignored by the compiler
public @interface DesignDecision {
    String[] roles(); // Add an array of fragment names
    }














