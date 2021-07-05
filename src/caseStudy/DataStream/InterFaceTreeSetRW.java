package caseStudy.DataStream;

import java.util.Set;

public interface InterFaceTreeSetRW<T> {
    Set<T> readFileByteStream(String path);
    void writeFileByteStream(Set<T> ts, String path);
    void clearData(String path);
}
