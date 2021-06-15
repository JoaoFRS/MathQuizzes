package com.example.mathquizzes.Database;

import com.example.mathquizzes.Database.Controllers.AddOperationController;
import com.example.mathquizzes.Database.Controllers.DivOperationController;
import com.example.mathquizzes.Database.Controllers.MultOperationController;
import com.example.mathquizzes.Database.Controllers.SubOperationController;
import com.example.mathquizzes.Database.Models.AddOperationModel;
import com.example.mathquizzes.Database.Models.DivOperationModel;
import com.example.mathquizzes.Database.Models.MultOperationModel;
import com.example.mathquizzes.Database.Models.SubOperationModel;

public class DatabaseBuilder {
    DatabaseHelper db;

    public DatabaseBuilder(DatabaseHelper database) {
        this.db = database;
    }

    public void buildUser(){
        AddOperationController addOperationController=new AddOperationController(db);
        AddOperationModel addOperationModel=new AddOperationModel(0);
        AddOperationModel addOperationModel1=new AddOperationModel(1);
        AddOperationModel addOperationModel2=new AddOperationModel(2);
        AddOperationModel addOperationModel3=new AddOperationModel(3);
        AddOperationModel addOperationModel4=new AddOperationModel(4);
        AddOperationModel addOperationModel5=new AddOperationModel(5);
        AddOperationModel addOperationModel6=new AddOperationModel(6);
        AddOperationModel addOperationModel7=new AddOperationModel(7);
        AddOperationModel addOperationModel8=new AddOperationModel(8);
        AddOperationModel addOperationModel9=new AddOperationModel(9);
        addOperationController.insertAddOperation(addOperationModel);
        addOperationController.insertAddOperation(addOperationModel1);
        addOperationController.insertAddOperation(addOperationModel2);
        addOperationController.insertAddOperation(addOperationModel3);
        addOperationController.insertAddOperation(addOperationModel4);
        addOperationController.insertAddOperation(addOperationModel5);
        addOperationController.insertAddOperation(addOperationModel6);
        addOperationController.insertAddOperation(addOperationModel7);
        addOperationController.insertAddOperation(addOperationModel8);
        addOperationController.insertAddOperation(addOperationModel9);

        SubOperationController subOperationController=new SubOperationController(db);
        SubOperationModel subOperationModel=new SubOperationModel(0);
        SubOperationModel subOperationModel1=new SubOperationModel(1);
        SubOperationModel subOperationModel2=new SubOperationModel(2);
        SubOperationModel subOperationModel3=new SubOperationModel(3);
        SubOperationModel subOperationModel4=new SubOperationModel(4);
        SubOperationModel subOperationModel5=new SubOperationModel(5);
        SubOperationModel subOperationModel6=new SubOperationModel(6);
        SubOperationModel subOperationModel7=new SubOperationModel(7);
        SubOperationModel subOperationModel8=new SubOperationModel(8);
        SubOperationModel subOperationModel9=new SubOperationModel(9);
        subOperationController.insertSubOperation(subOperationModel);
        subOperationController.insertSubOperation(subOperationModel1);
        subOperationController.insertSubOperation(subOperationModel2);
        subOperationController.insertSubOperation(subOperationModel3);
        subOperationController.insertSubOperation(subOperationModel4);
        subOperationController.insertSubOperation(subOperationModel5);
        subOperationController.insertSubOperation(subOperationModel6);
        subOperationController.insertSubOperation(subOperationModel7);
        subOperationController.insertSubOperation(subOperationModel8);
        subOperationController.insertSubOperation(subOperationModel9);

        MultOperationController multOperationController=new MultOperationController(db);
        MultOperationModel multOperationModel=new MultOperationModel(0);
        MultOperationModel multOperationModel1=new MultOperationModel(1);
        MultOperationModel multOperationModel2=new MultOperationModel(2);
        MultOperationModel multOperationModel3=new MultOperationModel(3);
        MultOperationModel multOperationModel4=new MultOperationModel(4);
        MultOperationModel multOperationModel5=new MultOperationModel(5);
        MultOperationModel multOperationModel6=new MultOperationModel(6);
        MultOperationModel multOperationModel7=new MultOperationModel(7);
        MultOperationModel multOperationModel8=new MultOperationModel(8);
        MultOperationModel multOperationModel9=new MultOperationModel(9);
        multOperationController.insertMultOperation(multOperationModel);
        multOperationController.insertMultOperation(multOperationModel1);
        multOperationController.insertMultOperation(multOperationModel2);
        multOperationController.insertMultOperation(multOperationModel3);
        multOperationController.insertMultOperation(multOperationModel4);
        multOperationController.insertMultOperation(multOperationModel5);
        multOperationController.insertMultOperation(multOperationModel6);
        multOperationController.insertMultOperation(multOperationModel7);
        multOperationController.insertMultOperation(multOperationModel8);
        multOperationController.insertMultOperation(multOperationModel9);


        DivOperationController divOperationController=new DivOperationController(db);
        DivOperationModel divOperationModel=new DivOperationModel(0);
        DivOperationModel divOperationModel1=new DivOperationModel(1);
        DivOperationModel divOperationModel2=new DivOperationModel(2);
        DivOperationModel divOperationModel3=new DivOperationModel(3);
        DivOperationModel divOperationModel4=new DivOperationModel(4);
        DivOperationModel divOperationModel5=new DivOperationModel(5);
        DivOperationModel divOperationModel6=new DivOperationModel(6);
        DivOperationModel divOperationModel7=new DivOperationModel(7);
        DivOperationModel divOperationModel8=new DivOperationModel(8);
        DivOperationModel divOperationModel9=new DivOperationModel(9);
        divOperationController.insertDivOperation(divOperationModel);
        divOperationController.insertDivOperation(divOperationModel1);
        divOperationController.insertDivOperation(divOperationModel2);
        divOperationController.insertDivOperation(divOperationModel3);
        divOperationController.insertDivOperation(divOperationModel4);
        divOperationController.insertDivOperation(divOperationModel5);
        divOperationController.insertDivOperation(divOperationModel6);
        divOperationController.insertDivOperation(divOperationModel7);
        divOperationController.insertDivOperation(divOperationModel8);
        divOperationController.insertDivOperation(divOperationModel9);

    }
}
