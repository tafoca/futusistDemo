package com.myWebService.futusistDemo.models;

public class Scope {
    public interface FirstLevel {}
    public interface SecondLevel extends FirstLevel{}
    public interface ThirdLevel extends SecondLevel {}
}