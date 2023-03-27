// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val cursoAtual: ConteudoEducacional){

    var cursosConcluidos = mutableListOf<ConteudoEducacional>()

    fun cursoConcluido(curso: ConteudoEducacional){
        cursosConcluidos.add(curso)
    }

}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel : Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }


}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val orientacaoObjetos = ConteudoEducacional("Orientacao a Objetos", 120, Nivel.INTERMEDIARIO)
    val bancoDados = ConteudoEducacional("Banco de Dados", 100, Nivel.INTERMEDIARIO)
    val desafiosCodigo = ConteudoEducacional("Desafios de Código", 300, Nivel.AVANCADO)
    val conteitosBasicos = ConteudoEducacional("Conceitos Básicos", 60, Nivel.BASICO)
    val estruturasRepeticao = ConteudoEducacional("Estruturas de Repetição", 60, Nivel.BASICO)
    val tratamentoExcecoes = ConteudoEducacional("Tratamento de Exceções", 120, Nivel.INTERMEDIARIO)

    var formacaoKotlin = Formacao(
        "Formação Linguagem Kotlin",
        listOf(conteitosBasicos, estruturasRepeticao, orientacaoObjetos, bancoDados)
    )
    var formacaoJava = Formacao("Formação Linguagem Java",
    listOf(conteitosBasicos, orientacaoObjetos, tratamentoExcecoes, bancoDados)
    )
    var formacaoJavascript = Formacao("Formação Linguagem Javascript",
    listOf(conteitosBasicos, estruturasRepeticao, orientacaoObjetos, desafiosCodigo)
    )

    var marvin = Usuario("Marvin", formacaoJava.conteudos[1])
    var joao = Usuario("João", formacaoJavascript.conteudos[2])
    var maria = Usuario("Maria", formacaoKotlin.conteudos[3])

    
    formacaoJava.matricular(marvin)
    marvin.cursoConcluido(formacaoJava.conteudos[0])

    formacaoKotlin.matricular(maria)
    maria.cursoConcluido(formacaoKotlin.conteudos[0])
    maria.cursoConcluido(formacaoKotlin.conteudos[1])
    maria.cursoConcluido(formacaoKotlin.conteudos[2])

    formacaoJavascript.matricular(joao)
    joao.cursoConcluido(formacaoJavascript.conteudos[0])
    joao.cursoConcluido(formacaoJavascript.conteudos[1])
}
