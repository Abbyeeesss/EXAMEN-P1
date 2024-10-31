class Guerrero {
    String nombre;
    String raza;
    int nivelPoder;
    String habilidad;

    public Guerrero(String nombre, String raza, int nivelPoder, String habilidad) {
        this.nombre = nombre;
        this.raza = raza;
        this.nivelPoder = nivelPoder;
        this.habilidad = habilidad;
    }
    public Guerrero() {
        this.nombre = "Gohan";
        this.raza = "Saiyajin";
        this.nivelPoder = 850;
        this.habilidad = "Masenko";
    }
}