import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
//@Accessors(chain = true,fluent = true)
@AllArgsConstructor
@ToString
public class Student {
    String name;

}