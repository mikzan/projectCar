package com.betacom.carjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.carjpa.model.Msg;
import com.betacom.carjpa.model.MsgID;

public interface IMsgRepository extends JpaRepository<Msg, MsgID>{

}
