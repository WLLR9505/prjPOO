
package fatec.poo.model;

public abstract class Pessoa {
    private String cpf;
    private String nome;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;
    private String ddd;
    private String telefone;

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf(){
        return cpf;
    }

    public String getNome(){
        return nome;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getCidade(){
        return cidade;
    }

    public String getUf(){
        return uf;
    }

    public String getCep(){
        return cep;
    }

    public String getDdd(){
        return ddd;
    }

    public String getTelefone(){
        return telefone;
    }

    public static boolean validarCPF(String cpf) {
        int soma=0, i, j, d1=0, d2=0;
        
        if (cpf.length() != 11 ||
            cpf.equals("00000000000") ||
            cpf.equals("11111111111") ||
            cpf.equals("22222222222") ||
            cpf.equals("33333333333") ||
            cpf.equals("44444444444") ||
            cpf.equals("55555555555") ||
            cpf.equals("66666666666") ||
            cpf.equals("77777777777") ||
            cpf.equals("88888888888") ||
            cpf.equals("99999999999")
        ) return false;

        for (i=0; i<9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (i+1);
        }

        d1 = soma % 11;
        if (d1 == 10) d1 = 0;

        if (Character.getNumericValue(cpf.charAt(9)) != d1) return false;

        for (i=0, j=11; i<10; i++, j--) {
            d2 += Character.getNumericValue(cpf.charAt(i)) * j;
        }

        d2 = (d2*10)%11;
        if (d2 == 10) d2 = 0;

        if (Character.getNumericValue(cpf.charAt(10)) != d2) return false;

        return true;
    }
}
