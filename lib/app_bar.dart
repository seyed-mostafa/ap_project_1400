import 'package:flutter/material.dart';
import 'package:testt/theme.dart';



AppBar app_bar(){
    return  AppBar(
        backgroundColor:Colors.white ,
        title: Text('Foodina',style: TextStyle(color: theme.yellow,
            fontSize: 30, fontWeight: FontWeight.bold,fontStyle: FontStyle.italic)),
        centerTitle: true,
        elevation: 10,
        actions: [
          IconButton(icon:Icon( Icons.map,color: Colors.black45))
        ],
      );

  }

