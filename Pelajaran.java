class Pelajaran{
    String mataPelajaran;
    int nilai;

    public Pelajaran(String mapel, int nil){
        this.mataPelajaran = mapel;
        this.nilai = nil;
    }

    public String getMapel(){
        return this.mataPelajaran;
    }

    public int getNilai(){
        return this.nilai;
    }
}