package week02;

import java.util.*;

/*
 * Root Interface of Collection Framework
 * Subsets of the Collection Framework:
 * List, Set, Queue
 * Collections Utility class has predefined static methods:
 * sort(),reverse(), shuffle(), binarySearch(), disjoint()
 *
 * list, set, queue, tree
 * */
public class MyCollections {
    private String location;
    private String project;
    private String person;
    private byte priority;


    public static void main(String[] args) {

            /*
             A list is an ordered collection, also known as a sequence.
             Duplicates are generally permitted. Allows positional access.
            */
        System.out.println("~~people list~~");
        List<String> people = new ArrayList<String>();
        people.add("Spencer");
        people.add("Meggin");
        people.add("Alex");
        people.add("Joey");
        people.add("Team effort");
        people.add("Kids");
        people.add("Girls");
        people.add("Boys");

        for (String projects : people)
            System.out.println(projects);
            /*
             A set is a collection without duplicate elements and may or may not be
             ordered.
            */
        System.out.println("~~Priority Set~~");
        SortedSet<String> prioritySet = new TreeSet<String>();
        prioritySet.add("First");
        prioritySet.add("Second");
        prioritySet.add("Third");
        prioritySet.add("Fourth");
        prioritySet.add("Fifth");
        prioritySet.add("Sixth");
        prioritySet.add("Seventh");
        prioritySet.add("Eighth");

        for (Object string : prioritySet) {
            System.out.println((String) string);
        }

            /*
            A queue is a collection designed for holding elements before processing
             */
        System.out.println("~~queue of projects~~");
        Queue<String> projectQueue = new PriorityQueue<String>();
        projectQueue.add("Hall closet floor refinishing.");
        projectQueue.add("Remove trees by neighbor's house.");
        projectQueue.add("Remove tree by bridge.");
        projectQueue.add("Expand bridge width.");
        projectQueue.add("Clean out girl's closet.");
        projectQueue.add("Reorganize master closet.");
        projectQueue.add("Build new shed.");
        projectQueue.add("Convert upstairs to bed/bath unit.");

        Iterator<String> iterator = projectQueue.iterator();
        while (iterator.hasNext()) {
            System.out.println(projectQueue.poll());
        }

            /*
            A map is used to connect keys and values and performs fast searches in your collection.
            They need 2 things, the key and the value associated to it.
             */

        System.out.println("~~Project map~~");
        Map projectMap = new HashMap();
        projectMap.put(1, "Hall closet floor refinishing.");
        projectMap.put(2, "Clean out girl's closet.");
        projectMap.put(3, "Remove tree by bridge.");
        projectMap.put(4, "Expand bridge width.");
        projectMap.put(5, "Remove trees by neighbors house.");
        projectMap.put(6, "Reorganize master closet.");
        projectMap.put(7, "Convert upstairs to bed/bath unit.");
        projectMap.put(8, "Build new shed.");

        for (int i = 1; i < 8; i++) {
            String myMap = (String) projectMap.get(i);
            System.out.println(myMap);


        }
        System.out.println("~~Generic Project List~~");
        List<MyProjects> prioritizedProjects = new LinkedList<MyProjects>();
        prioritizedProjects.add(new MyProjects(projectMap.get(1)));
        prioritizedProjects.add(new MyProjects(projectMap.get(2)));
        prioritizedProjects.add(new MyProjects(projectMap.get(3)));
        prioritizedProjects.add(new MyProjects(projectMap.get(4)));
        prioritizedProjects.add(new MyProjects(projectMap.get(5)));
        prioritizedProjects.add(new MyProjects(projectMap.get(6)));
        prioritizedProjects.add(new MyProjects(projectMap.get(7)));
        prioritizedProjects.add(new MyProjects(projectMap.get(8)));
    }

}
