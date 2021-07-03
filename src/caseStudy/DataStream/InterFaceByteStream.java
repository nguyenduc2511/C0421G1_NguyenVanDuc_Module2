package caseStudy.DataStream;

import java.util.List;

public interface InterFaceByteStream<T> {
    List<T> readFileByteStream(String path);

    void writeFileByteStream(List<T> ts, String path);
    void clearData(String path);

}
