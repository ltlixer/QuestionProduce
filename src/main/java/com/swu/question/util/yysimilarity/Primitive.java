/*
 * Copyright (C) 2008 SKLSDE(State Key Laboratory of Software Development and Environment, Beihang University)., All Rights Reserved.
 */
package com.swu.question.util.yysimilarity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 义原
 * 
 * @author Yingqiang Wu
 * @version 1.0
 */
public class Primitive {
    /**
     * DOCUMENT ME!
     */
    public Map<Integer, Primitive> ALLPRIMITIVES = new HashMap<Integer, Primitive>();

    /**
     * DOCUMENT ME!
     */
    public Map<String, Integer> PRIMITIVESID = new HashMap<String, Integer>();
    /**
     * 加载义原文件。
     */
    /*
    static {
        String line = null;

        try {
        	InputStreamReader isr = new InputStreamReader(new FileInputStream("src/main/webapp/resources/dict/WHOLE.DAT"), "GBK");
            BufferedReader reader = new BufferedReader(isr);
            line = reader.readLine();

            while (line != null) {
                line = line.trim().replaceAll("\\s+", " ");

                String[] strs = line.split(" ");
                int id = Integer.parseInt(strs[0]);
                String[] words = strs[1].split("\\|");
                String english = words[0];
                String chinaese = strs[1].split("\\|")[1];
                int parentId = Integer.parseInt(strs[2]);
                ALLPRIMITIVES.put(id, new Primitive(id, chinaese, parentId));
                //ALLPRIMITIVES.put(id, new Primitive(id, english, parentId));
                PRIMITIVESID.put(chinaese, id);
                PRIMITIVESID.put(english, id);
                // System.out.println("add: " + primitive + " " + id + " " + parentId);
                line = reader.readLine();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(line);
            e.printStackTrace();
        }
    }*/
	
    private String primitive;

    /**
     * id number
     */
    private int id;
    private int parentId;
    
    public Primitive(){
    	String line = null;

        try {
        	InputStreamReader isr = new InputStreamReader(new FileInputStream("src/main/webapp/resources/dict/WHOLE.DAT"), "GBK");
            BufferedReader reader = new BufferedReader(isr);
            line = reader.readLine();

            while (line != null) {
                line = line.trim().replaceAll("\\s+", " ");

                String[] strs = line.split(" ");
                int id = Integer.parseInt(strs[0]);
                String[] words = strs[1].split("\\|");
                String english = words[0];
                String chinaese = strs[1].split("\\|")[1];
                int parentId = Integer.parseInt(strs[2]);
                ALLPRIMITIVES.put(id, new Primitive(id, chinaese, parentId));
                //ALLPRIMITIVES.put(id, new Primitive(id, english, parentId));
                PRIMITIVESID.put(chinaese, id);
                PRIMITIVESID.put(english, id);
                // System.out.println("add: " + primitive + " " + id + " " + parentId);
                line = reader.readLine();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(line);
            e.printStackTrace();
        }
    }
    
    /**
     * Creates a new Primitive object.
     * 
     * @param id
     *            DOCUMENT ME!
     * @param primitive
     *            DOCUMENT ME!
     * @param parentId
     *            DOCUMENT ME!
     */
    public Primitive(int id, String primitive, int parentId) {
        this.id = id;
        this.parentId = parentId;
        this.primitive = primitive;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public String getPrimitive() {
        return primitive;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public int getId() {
        return id;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public int getParentId() {
        return parentId;
    }

    /**
     * DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public boolean isTop() {
        return id == parentId;
    }

    /**
     * 获得一个义原的所有父义原，直到顶层位置。
     * 
     * @param primitive
     * @return 如果查找的义原没有查找到，则返回一个空list
     */
    public List<Integer> getParents(String primitive) {
        List<Integer> list = new ArrayList<Integer>();

        // get the id of this primitive
        Integer id = PRIMITIVESID.get(primitive);

        if (id != null) {
            Primitive parent = ALLPRIMITIVES.get(id);
            list.add(id);
            while (!parent.isTop()) {
                list.add(parent.getParentId());
                parent = ALLPRIMITIVES.get(parent.getParentId());
            }
        }

        return list;
    }
    /**
     * 
     * @param primitive
     * @return
     */
    public boolean isPrimitive(String primitive){
        return PRIMITIVESID.containsKey(primitive);
    }
}
