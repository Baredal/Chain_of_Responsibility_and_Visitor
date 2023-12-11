package task2;


import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ucu.edu.ua.apps.task2.Group;
import ucu.edu.ua.apps.task2.Signature;
import ucu.edu.ua.apps.task2.StampingVisitor;
import ucu.edu.ua.apps.task2.Task;
public class StampingVisitorTest implements StampingVisitor<String>{

    @Test
    void testStamps() {
        StampingVisitor<String> stampingVisitor = new StampingVisitorTest();


        Signature<String> signature = new Signature<>(s -> {});
        signature.stamp(stampingVisitor);


        Assertions.assertEquals("signatureId", signature.getHeader("signature"));
    }

    @Test
    void testGroupStamps() {
        StampingVisitor<String> stampingVisitor = new StampingVisitorTest();

        Group<String> group = new Group<>();
        Signature<String> signature = new Signature<>(s -> {});
        group.addTask(signature);
        group.stamp(stampingVisitor);

        // Verify the stamping results
        Assertions.assertEquals("groupId", group.getHeader("groups"));
        Assertions.assertEquals("signatureId", group.getHeader("signature"));

    }

    @Override
    public Map<String, String> onGroupStart(Task<String> task) {
        return Map.of("groups", "groupId", "signature", "signatureId");
    }

    @Override
    public Map<String, String> onGroupEnd(Task<String> task) {

        return Map.of("groups", "groupId", "signature", "signatureId");
    }

    @Override
    public Map<String, String> onSignature(Task<String> task) {
        return Map.of("groups", "groupId", "signature", "signatureId");
    }
}
