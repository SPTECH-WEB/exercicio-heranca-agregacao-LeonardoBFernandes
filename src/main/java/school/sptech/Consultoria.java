package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria() {}

    public void contratar(Desenvolvedor desenvolvedor) {
        if (vagas > 0 && desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack()) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios() {
        Double somaSalarios = 0.0;
        for (Desenvolvedor d:desenvolvedores) {
            somaSalarios += d.calcularSalario();
        }
        return somaSalarios;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer qtdDevsMobile = 0;
        for (Desenvolvedor d:desenvolvedores) {
            if (d instanceof DesenvolvedorMobile) {
                qtdDevsMobile++;
            }
        }
        return qtdDevsMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> devsComSalarioMaiorIgualQue = new ArrayList<>();
        for (Desenvolvedor d:desenvolvedores) {
            if (d.calcularSalario() >= salario) {
                devsComSalarioMaiorIgualQue.add(d);
            }
        }
        return devsComSalarioMaiorIgualQue;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {
            return null;
        }

        Double menorSalario = desenvolvedores.get(0).calcularSalario();
        Desenvolvedor devMenorSalario = desenvolvedores.get(0);

        for (Desenvolvedor d:desenvolvedores) {
            if (d.calcularSalario() < menorSalario) {
                menorSalario = d.calcularSalario();
                devMenorSalario = d;
            }
        }
        return devMenorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> devsNessaTecnologia = new ArrayList<>();
        for (Desenvolvedor d:desenvolvedores) {
            if (d instanceof DesenvolvedorMobile) {
                if (Objects.equals(((DesenvolvedorMobile) d).getPlataforma(), tecnologia) ||
                        Objects.equals(((DesenvolvedorMobile) d).getLinguagem(), tecnologia)) {
                    devsNessaTecnologia.add(d);
                }
            } else if (d instanceof DesenvolvedorWeb) {
                if (Objects.equals(((DesenvolvedorWeb) d).getBackend(), tecnologia) ||
                        Objects.equals(((DesenvolvedorWeb) d).getFrontend(), tecnologia) ||
                        Objects.equals(((DesenvolvedorWeb) d).getSgbd(), tecnologia)) {
                    devsNessaTecnologia.add(d);
                }
            }
        }
        return devsNessaTecnologia;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double somaSalarios = 0.0;
        for (Desenvolvedor d:desenvolvedores) {
            if (d instanceof DesenvolvedorMobile) {
                if (Objects.equals(((DesenvolvedorMobile) d).getPlataforma(), tecnologia) ||
                        Objects.equals(((DesenvolvedorMobile) d).getLinguagem(), tecnologia)) {
                    somaSalarios += d.calcularSalario();
                }
            } else if (d instanceof DesenvolvedorWeb) {
                if (Objects.equals(((DesenvolvedorWeb) d).getBackend(), tecnologia) ||
                        Objects.equals(((DesenvolvedorWeb) d).getFrontend(), tecnologia) ||
                        Objects.equals(((DesenvolvedorWeb) d).getSgbd(), tecnologia)) {
                    somaSalarios += d.calcularSalario();
                }
            }
        }
        return somaSalarios;
    }

    public String getNome() {
        return nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
