package listeners.MicrosoftTeams;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdaptiveCardReqBody{
	private List<AttachmentsItem> attachments;
	private String type;
}