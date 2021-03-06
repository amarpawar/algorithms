package com.algorithms.fcd;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Application
{
    public static void main(String[] args)
    {
        SinglyLinkedList<Integer> linkedList = generateList(false);
        SinglyLinkedList<Integer> cycledLinkedList = generateList(true);

        checkListForCycle(linkedList);
        checkListForCycle(cycledLinkedList);
    }

    public static void checkListForCycle(SinglyLinkedList<Integer> linkedList)
    {
        System.out.println("Checking cycle in list: ");
        SinglyLinkedList.Node<Integer> matchedNode = detectCycle(linkedList);

        if (Objects.isNull(matchedNode))
        {
            System.out.println("No cycle detected");
        }
        else
        {
            SinglyLinkedList.Node<Integer> startingNodeOfCycle = getStartingNodeOfCycle(linkedList, matchedNode);
            System.out.println("Cycle detected at node " + startingNodeOfCycle.toString());
        }

        System.out.println("\n");
    }

    public static SinglyLinkedList.Node<Integer> detectCycle(SinglyLinkedList<Integer> linkedList)
    {
        SinglyLinkedList.Node<Integer> tortoise = linkedList.getHead();
        SinglyLinkedList.Node<Integer> hare = linkedList.getHead();

        //Break the loop if you reach to hare reaches to the end of the list
        while (Objects.nonNull(hare) && Objects.nonNull(hare.getNext()))
        {
            //move tortoise by one step
            tortoise = tortoise.getNext();

            //move hare by two steps
            hare = hare.getNext().getNext();

            //if tortoise is equals to the hare which means we have detected the loop
            //return either tortoise or hare as both are same
            if (tortoise == hare)
            {
                return tortoise;
            }
        }

        return null;
    }

    public static SinglyLinkedList.Node<Integer> getStartingNodeOfCycle(SinglyLinkedList<Integer> linkedList, SinglyLinkedList.Node<Integer> matchedNode)
    {
        SinglyLinkedList.Node<Integer> head = linkedList.getHead();

        //break the loop when head and matchedNode are same
        while (head != matchedNode)
        {
            //move head by one step
            head = head.getNext();

            //move matchedNode by one step
            matchedNode = matchedNode.getNext();
        }

        return head;
    }

    public static SinglyLinkedList<Integer> generateList(boolean cycled)
    {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        int min = 1;
        int max = 10;
        Random random = new Random();

        for (int i=0; i<max; i++)
        {
            linkedList.addAtEnd(i);
        }

        if (cycled)
        {
            SinglyLinkedList.Node<Integer> head = linkedList.getHead();
            SinglyLinkedList.Node<Integer> cycledNode = null;
            int randomIndex = random.nextInt((max-5) - min + 1) + min;
            int counter = 1;

            while (Objects.nonNull(head.getNext()))
            {
                head = head.getNext();

                if (counter == randomIndex)
                {
                    cycledNode = head;
                }

                counter++;
            }

            head.setNext(cycledNode);
        }

        return linkedList;
    }
}
