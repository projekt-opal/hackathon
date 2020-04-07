package hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DatasetMapVisualController {
	
	
	@Autowired
	private DatasetMapVisualService mapService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("datasets",mapService.getAllDatasets("http://projekt-opal.de/dataset/https___europeandataportal_eu_set_data_00463555_c754_7faa_300d_300dd9b8a268","testdata.ttl"));
		return "map";
	}
}
