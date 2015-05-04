package upm.miw.pfm.utils;

public enum RoleType {
    PROJECT_MANAGEMENT("Gestión de proyectos"), REQUIREMENTS("Requisitos"), ANALYSIS_DESIGN(
            "Análisis y diseño"), IMPLEMENTATION("Implementación"), TESTS("Pruebas"), DEPLOY(
            "Despliegue"), ENVIROMENT_REVISION_CONTROL("Entorno y control de versiones");

    private String description;

    private RoleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
