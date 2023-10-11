# Código de Download e Instalação de Arquivos da Internet

Este código contém funções para fazer o download de arquivos da internet e é projetado para facilitar a cópia e implementação em outros projetos. As funções permitem baixar um arquivo da internet a partir de uma URL especificada e salvar localmente com o nome especificado.

## Funcionalidade Principai

### `downloadArq(url: URL, nomeArquivo: String)`

Essa função baixa um arquivo da internet a partir de uma URL especificada dada por você ou seu usuário e salva localmente com o nome especificado, incluindo a extensão do arquivo.

## Como Usar

Para usar a funcionalidade de download, basta chamar a função `installFromUrl()`. Certifique-se de ter as bibliotecas de Java instalada para executar o código.

```java
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import javax.swing.JOptionPane;

fun downloadArq(url: URL, nomeArquivo: String) {
    url.openStream().use { // abre a conexão com a url e cria um InputStream
        Channels.newChannel(it).use { rbc -> // cria um canal para ler
            FileOutputStream(nomeArquivo).use { fos -> // cria FileOutputStream para salvar
                fos.channel.transferFrom(rbc, 0, Long.MAX_VALUE) // transfere
            }
        }
    }
}

fun main() {
    installFromUrl()
}

fun installFromUrl() {
    val url = URL(JOptionPane.showInputDialog("Insira a url do que quer baixar")) // usuário insere o link
    val nomeArquivo = JOptionPane.showInputDialog(null, "Insira o nome do arquivo com a extensão") // nome do arquivo localmente com sua devida extensão
    downloadArq(url, nomeArquivo)
    println("Arquivo baixado com sucesso: $nomeArquivo")
}
```

## Observações

- Certifique-se de ter as permissões adequadas para executar scripts no seu sistema.
- Coloque a extensão correta
- A função `downloadArq()` baixa o arquivo da URL especificada e o salva no diretório onde o código está sendo executado. Certifique-se de ter permissão de escrita no diretório.

## Linguagem utilizada 

[![My Skills](https://skills.thijs.gg/icons?i=kotlin)](https://skills.thijs.gg)
