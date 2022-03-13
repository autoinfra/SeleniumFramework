package listeners.MicrosoftTeams;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColumnsItem{
	private String width;
	private String type;
	private List<ItemsItem> items;
	private String spacing;
	private String verticalContentAlignment;
	private SelectAction selectAction;
}