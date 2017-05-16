
import java.io.IOException;

import org.apache.pig.FilterFunc;
import org.apache.pig.data.Tuple;
import java.text.DecimalFormat;


public class IsDistrictCompleteTest extends FilterFunc {


    public Boolean exec(Tuple input) throws IOException {
	DecimalFormat df = new DecimalFormat("#.000");        
	// expect  string
   	boolean isComplete=false;
        double objective = Integer.parseInt(input.get(0).toString());
	double performance = Integer.parseInt(input.get(1).toString()); 	
	// double calc = (objective/performance) * 100;
        if (objective !=0 && objective != ' ' && performance != ' '){
	    // DecimalFormat df = new DecimalFormat("#.00000");
	    // df.format(0.912385)
	    double calc = Double.valueOf(df.format((performance/objective) * 100));
          if (calc >= Double.valueOf(df.format(80))) {	
	    	isComplete=true;
	}
        }
        return isComplete;
    }
}
