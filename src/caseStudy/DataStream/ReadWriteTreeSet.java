package caseStudy.DataStream;

import caseStudy.models.bookingAndContract.Booking;
import caseStudy.utils.BookingComparatorDate;
import caseStudy.models.bookingAndContract.Contract;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class ReadWriteTreeSet implements InterFaceTreeSetRW<Booking>{

    @Override
    public Set<Booking> readFileByteStream(String path) {
        Set<Booking> bookings = new TreeSet<>(new BookingComparatorDate());
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            bookings = (Set<Booking>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(" data null");
        }
        return bookings;
    }

    @Override
    public void writeFileByteStream(Set<Booking> bookings, String path) {
        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(bookings);
            objectOutputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearData(String path) {
        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(null);
            objectOutputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PriorityQueue<Contract> readFileByteStreamQ(String path) {
        PriorityQueue<Contract> contracts = new PriorityQueue<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            contracts = (PriorityQueue<Contract>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(" data null");
        }
        return contracts;
    }

    public void writeFileByteStreamQ(PriorityQueue<Contract> contracts, String path) {
        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(contracts);
            objectOutputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearDataQ(String path) {
        try {
            FileOutputStream outputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(null);
            objectOutputStream.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
