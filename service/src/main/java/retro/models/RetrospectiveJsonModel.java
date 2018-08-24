
package retro.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author radostina
 */
public class RetrospectiveJsonModel {
    
    private List<RetrospectiveModel> retrospective;

    public RetrospectiveJsonModel() {
        //No-op
    }

    public List<RetrospectiveModel> getJsonModels() {
        return retrospective;
    }

    public void setJsonModels(List<RetrospectiveModel> jsonModels) {
        this.retrospective = jsonModels;
    }

    public void addJsonModel(RetrospectiveModel model) {
        if (retrospective == null) {
            retrospective = new ArrayList<>();
        }
        
        retrospective.add(model);
    }
}
