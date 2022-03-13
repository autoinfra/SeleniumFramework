package listeners.MicrosoftTeams;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemsItem{
	private List<ColumnsItem> columns;
	private String type;
	private String size;
	private String weight;
	private String style;
	private String text;
	private boolean wrap;
	private String altText;
	private String url;
	private String height;
	private String color;
	private String width;
	private String id;
	private boolean isVisible;
	private List<ItemsItem> items;
	private String data;
	private boolean isSubtle;
	private List<ActionsItem> actions;
}