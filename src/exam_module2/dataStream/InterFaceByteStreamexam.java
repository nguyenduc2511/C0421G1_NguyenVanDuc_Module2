package exam_module2.dataStream;

import java.util.List;

public interface InterFaceByteStreamexam<T> {
    List<T> readFileByteStream(String path);
    void writeFileByteStream(List<T> ts, String path);

}
