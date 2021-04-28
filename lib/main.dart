

// main of the app


import 'package:testt/bottom_navigation .dart';
import 'package:flutter/material.dart';
import 'package:testt/list_view.dart';
import 'package:testt/app_bar.dart';




void main() => runApp(Store());


class Store extends StatefulWidget {
  @override
  _StoreState createState() => _StoreState();
}
class _StoreState extends State<Store> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: app_bar(),
         body: list_view(),
         bottomNavigationBar:bottom_navigation(),

        ),

    );
  }
}


