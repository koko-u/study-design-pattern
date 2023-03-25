package jp.co.kokou.visitors;

import jp.co.kokou.elements.Element;
import lombok.RequiredArgsConstructor;
import lombok.With;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Path;

/**
 * 往訪した Element を順にリストとして印字していく Visitor クラスです
 */
@RequiredArgsConstructor
@Slf4j
public class ListVisitor implements Visitor {

    /**
     * Element をディレクトリ、ファイルとして印字するときのベースとなる Path です
     * <p>
     * Note: Lombok の With を使うことで、自身を複製して currentDir のみ異なるインスタンスを作りやすくしている
     */
    @With
    private final Path currentDir;

    /**
     * Element を訪れて、パスのリストを印字していきます
     *
     * @param element 往訪する対象の Element （ディレクトリ、ファイル）
     */
    @Override
    public void visit(Element element) {
        // element.toString() はファイルの場合は「ファイル名 （サイズ）」
        // ディレクトリの場合は単なるディレクトリ名となることに注意する
        var thisPath = currentDir.resolve(element.toString());

        // 「起点 / element」を印字する
        log.info("{}", thisPath);

        // Element がどのように往訪するかを示す Iterator を公開している
        var iter = element.getIterator();
        while (iter.hasNext()) {
            // 「次の」 Element には、起点となるディレクトリをずらした Visitor を渡す
            iter.next().accept(this.withCurrentDir(thisPath));
        }
    }
}
