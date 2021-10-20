package cz.uhk.ppro.inzeraty.web;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import cz.uhk.ppro.inzeraty.sluzby.PametoveUlozisteInzeratu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InzeratController {
    private PametoveUlozisteInzeratu inzeraty = null;
    public PametoveUlozisteInzeratu getPametoveUlozisteInzeratu() {
        return inzeraty;
    }
    @Autowired
    public void setPametoveUlozisteInzeratu(PametoveUlozisteInzeratu ui){
        this.inzeraty = ui;
    }

    /*@RequestMapping("/inzeratyy")
    @ResponseBody
    public List<Inzerat> zobrazitt(){
        return inzeraty.getInzeraty();
    }*/

    @RequestMapping("/inzeraty")
    public ModelAndView zobrazit(@RequestParam(value="kategorie",required=false) String kategorie){
        ModelAndView model = new ModelAndView("seznam");

        if(kategorie != null){
            model.addObject("inzeraty", inzeraty.getInzeratyByKategorie(kategorie));
        }
        else{
            model.addObject("inzeraty", inzeraty.getInzeraty());
        }

        return model;
    }
    @RequestMapping("/")
    public String redirect(){
        return "redirect:/inzeraty";
    }
}
