package cz.uhk.ppro.inzeraty;


import cz.uhk.ppro.inzeraty.model.Inzerat;
import cz.uhk.ppro.inzeraty.sluzby.PametoveUlozisteInzeratu;
import cz.uhk.ppro.inzeraty.sluzby.UlozisteInzeratu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.math.BigDecimal;

@SpringBootApplication
public class InzeratyApplication implements WebMvcConfigurer {


    public static void main(String[] args) {
        SpringApplication.run(InzeratyApplication.class, args);
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // namapovat URL / na view jmenem index (tedy pres view-resolver na /WEB>-INF/jsp/index.jsp)
        registry.addViewController("/").setViewName("index");
    }


    @Bean
    @Primary
    PametoveUlozisteInzeratu getInzeraty(){
        PametoveUlozisteInzeratu list = new PametoveUlozisteInzeratu();
        Inzerat i =  new Inzerat();
        i.setId(0);
        i.setText("Text inzerátu - MOTO");
        i.setKategorie("Moto");
        i.setCena(new BigDecimal("300"));
        list.pridej(i);

        Inzerat i2 =  new Inzerat();
        i2.setId(1);
        i2.setText("Text inzerátu - RETRO ");
        i2.setKategorie("Retro");
        i2.setCena(new BigDecimal("500"));
        list.pridej(i2);

        Inzerat i3 =  new Inzerat();
        i3.setId(2);
        i3.setText("Text inzerátu - NOTEBOOKY");
        i3.setKategorie("Notebooky");
        i3.setCena(new BigDecimal("2000"));
        list.pridej(i3);

        return list;
    }

}
