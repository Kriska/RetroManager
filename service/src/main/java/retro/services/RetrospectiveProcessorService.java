
package retro.services;

import org.springframework.stereotype.Component;
import retro.models.RetrospectiveJsonModel;
import retro.models.RetrospectiveModel;
import retro.models.RetrospectiveSummaryModel;

/**
 *
 * @author C50117A
 */
@Component
public class RetrospectiveProcessorService {    
    
    public RetrospectiveProcessorService() {
        //No-op
    }
    
    public RetrospectiveSummaryModel processRetrospective(RetrospectiveJsonModel retrospectiveJsonModel) {
        RetrospectiveSummaryModel summary = new RetrospectiveSummaryModel();
        
        for (RetrospectiveModel model : retrospectiveJsonModel.getJsonModels()) {
            summary.addToSprintWeather(model.getSprintWeather());
            summary.addToDidWell(model.getDidWell());
            summary.addToWentWrong(model.getWentWrong());
            summary.addToDoDifferently(model.getDoDifferently());
            summary.addToOutOfTeamControl(model.getOutOfTeamControl());
        }
        
        return summary;
    }
}
