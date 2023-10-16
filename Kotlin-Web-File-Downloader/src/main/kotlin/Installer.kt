import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.nio.channels.Channels
import javax.swing.JOptionPane

/**
 * codigo de criação de arquivos de dowloads de arquivos da internet com exemplos úteis, fácil de copiar
 * para aplicar em projetos que executa funções para realizar o download de um arquivo da internet dado
 * uma url e nome do arquivo de destino.
 * a função utiliza entrada e saída de streams para efetuar o download do arquivo e criar o arquivo local.
 * parametro  url a url do arquivo a ser baixado.
 * parametro nomeArquivo o nome do arquivo de destino onde o conteúdo será salvo.
 * além d utilização da criação de arquivos também fácil para a copia
 **/

fun main() {

    // url de exemplo http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4

    val url = URL(JOptionPane.showInputDialog("Insira a url do que quer baixar"))
    val nomeArquivo = JOptionPane.showInputDialog(
        null,
        "insira o nome do arquivo contando com sua extensão"
    ) // nome do arquivo localmente 



    installFromUrl(url, nomeArquivo)
}

// função para baixar um arquivo da URL e salvar no disco com o nome especificado
fun downloadArq(url: URL, nomeArquivo: String) {
    url.openStream().use { // abre a conexão com a url e cria um InputStream
        Channels.newChannel(it).use { rbc -> // cria um canal para ler
            FileOutputStream(nomeArquivo).use { fos -> // cria FileOutputStream para salvar
                fos.channel.transferFrom(rbc, 0, Long.MAX_VALUE) // transfere
            }
        }
    }
}

fun installFromUrl(url: URL, nomeArquivo: String) {
    downloadArq(url, nomeArquivo)
    println("Arquivo baixado com sucesso: $nomeArquivo")
}

fun installFromUrlYoutube(url: URL, nomeArquivo: String: String) {
    val url = URL(JOptionPane.showInputDialog("Insira a url do que quer baixar"))
    val nomeArquivo = JOptionPane.showInputDialog(
        null,
        "insira o nome do arquivo contando com sua extensão"
    ) // nome do arquivo localmente
    downloadArq(url, nomeArquivo)
    println("Arquivo baixado com sucesso: $nomeArquivo")
}