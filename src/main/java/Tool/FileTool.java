package Tool;

import ReadJson.Item;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 *
 * @author mezereon E-mail:mezereon@gmail.com
 * @since 18-4-12
 */
public class FileTool {

  /**
   * 通过json文件获取时间序列数据
   */
  public static double[] getData(String filePath) throws FileNotFoundException {
    Gson gson = new Gson();
    Reader reader = new FileReader(filePath);
    Item[] items = gson.fromJson(reader, Item[].class);
    double[] series = new double[items.length];

    System.out.println(items.length);

    int i = 0;
    for (Item item : items) {
      series[i++] = item.getEvent().getTotal_count() / (60 * 60 * 1000);
      System.out.println(item.getEvent().getTotal_count() / (60 * 60 * 1000) );
    }
    return series;

  }
}
