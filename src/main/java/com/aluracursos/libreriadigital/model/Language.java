package com.aluracursos.libreriadigital.model;


public enum Language {
    es("Español"),
    en("Inglés"),
    fr("Francés"),
    pt("Portugués"),
    nd("No disponible"),
    ;

    private String totalIdiomas;

    Language(String totalIdiomas){
        this.totalIdiomas=totalIdiomas;
    }

    public static Language stringToEnum(String idioma){
        for(Language item:Language.values()){
            if(item.name().equalsIgnoreCase(idioma)){
                return item;
            }
        }
        return nd;
    }

    public static void listarIdiomas(){
        for (Language idioma:Language.values()){
            System.out.println(idioma.name()+" - "+idioma.getTotalIdiomas());
        }
    }

    public String getTotalIdiomas() {
        return totalIdiomas;
    }
}
