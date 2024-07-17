package br.com.moacyr.itcollection.service;

public interface IDataConverter {

    <T> T getData(String json, Class<T> tClass);
}
