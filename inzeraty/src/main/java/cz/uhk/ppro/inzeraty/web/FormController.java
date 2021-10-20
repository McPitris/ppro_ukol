package cz.uhk.ppro.inzeraty.web;

import cz.uhk.ppro.inzeraty.model.Inzerat;
import cz.uhk.ppro.inzeraty.sluzby.PametoveUlozisteInzeratu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("inzeraty/add")
public class FormController {
    private PametoveUlozisteInzeratu inzeraty = null;
    @Autowired
    public void setPametoveUlozisteInzeratu(PametoveUlozisteInzeratu ui){
        this.inzeraty = ui;
    }

    @RequestMapping(method= RequestMethod.POST)
    protected String onSubmit(@RequestParam(value="id",required=false) Integer id,
                              @ModelAttribute("inzerat") Inzerat inzerat,
                              @RequestParam("heslo") String heslo,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "inzeratForm";
        }

        if(id != null){
            if (!inzeraty.getById(id).getHesloProUpravu().equals(heslo)){
                return "redirect:/inzeraty/add?id="+id;
            }
            inzeraty.odstran(id);
            inzeraty.pridej(inzerat);
            inzeraty.getById(inzerat.getId()).setId(id);
        }
        else {
            inzerat.setHesloProUpravu(heslo);
            inzeraty.pridej(inzerat);
        }
        return "redirect:/inzeraty";
    }
    @RequestMapping(method=RequestMethod.GET)
    protected String form(@RequestParam(value="id",required=false) Integer id, Model m) {
        //Priprava dat pro form, pokud je zadano id polozky, pak bude predvyplnena
        if (id!=null) {
            m.addAttribute("inzerat", inzeraty.getById(id));

        } else {
            // pokud vytvarime novou polozku, tak do JSP predame novou instanci
            m.addAttribute("inzerat", new Inzerat());
        }
        return "inzeratForm";
    }
}
