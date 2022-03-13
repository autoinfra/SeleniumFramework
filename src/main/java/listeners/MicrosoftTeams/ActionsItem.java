package listeners.MicrosoftTeams;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder

public class ActionsItem{
	private String style;
	private String type;
	private String title;
	private String url;
}