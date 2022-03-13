package listeners.MicrosoftTeams;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BodyItem{
	private String type;
	private List<ItemsItem> items;
	private String id;
	private boolean isVisible;
	private String spacing;
	private List<FactsItem> facts;
	private String style;
	private String text;
}