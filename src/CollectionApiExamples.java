import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CollectionApiExamples {

    public static void main(String[] args) {
        CollectionApiExamples e = new CollectionApiExamples();
        e.testRemoveIf();
        //e.testListSort();
        //e.testListReplaceAll();
        //e.testMapRemoveIfAbsent();
        //e.testMapRemove();
        //e.testMapReplace1();
        //e.testMapReplace2();
        //e.testGetOrDefault();
    }

    private void testGetOrDefault() {
        Map<String, String> animalInitials = new HashMap<>();
        animalInitials.put("K", "kangaroo");
        System.out.println(animalInitials.getOrDefault("K", "koala"));
        System.out.println(animalInitials.getOrDefault("L", "lemur"));
    }

    private void testMapReplace2() {
        Map<String, String> animalInitials = new HashMap<>();
        animalInitials.put("J", "jackal");
        System.out.println(animalInitials);
        animalInitials.replace("J", "jaguar", "jellyfish");
        System.out.println(animalInitials);
        animalInitials.replace("J", "jackal", "jellyfish");
        System.out.println(animalInitials);
    }

    private void testMapReplace1() {
        Map<String, String> animalInitials = new HashMap<>();
        animalInitials.replace("I", "iguana");
        System.out.println(animalInitials);
        animalInitials.put("I", "impala");
        System.out.println(animalInitials);
        animalInitials.replace("I", "iguana");
        System.out.println(animalInitials);
    }

    private void testMapRemove() {
        Map<String, String> animalInitials = new HashMap<>();
        animalInitials.put("H", "heron");
        System.out.println(animalInitials);
        animalInitials.remove("H", "humpback whale");
        System.out.println(animalInitials);
        animalInitials.remove("H", "heron");
        System.out.println(animalInitials);
    }

    private void testMapRemoveIfAbsent() {
        Map<String, String> animalInitials = new HashMap<>();
        animalInitials.put("F", "ferret");
        animalInitials.putIfAbsent("G", "gazelle");
        animalInitials.putIfAbsent("G", "goose");
        System.out.println(animalInitials);
    }

    private void testListReplaceAll() {
        List<String> strings = new ArrayList<>();
        strings.add("aardvark");
        strings.add("bat");
        strings.add("cat");
        strings.add("dodo");
        strings.add("elephant");
        System.out.println(strings);
        strings.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        });
        System.out.println(strings);
    }

    public void testListSort() {
        List<Integer> ints = new ArrayList<>();
        ints.add(7); ints.add(42); ints.add(13);
        ints.add(-10); ints.add(582); ints.add(0);
        System.out.println(ints);
        ints.sort(null);
        System.out.println(ints);
    }

    public void testRemoveIf() {
        List<String> strings = new ArrayList<>();
        strings.add("aardvark");
        strings.add("bat");
        strings.add("cat");
        strings.add("dodo");
        strings.add("elephant");
        strings.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 4;
            }
        });
        System.out.println(strings);
    }

}
