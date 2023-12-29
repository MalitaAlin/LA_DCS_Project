package ProjectLA;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataCar;
import DataObjects.DataCarQueue;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;



public class ConnectionStreet {
        public static void main(String[] args) {
            PetriNet pn = new PetriNet();
            pn.PetriNetName = "Connection Street PN";
            pn.NetworkPort = 1091;

            //--- Places  Types
            //--- DataCarQueue
            DataCarQueue p1 = new DataCarQueue();
            p1.Value.Size = 3;
            p1.SetName("p1");
            pn.PlaceList.add(p1);

            DataCarQueue p2 = new DataCarQueue();
            p2.Value.Size = 3;
            p2.SetName("p2");
            pn.PlaceList.add(p2);

            DataCarQueue p3 = new DataCarQueue();
            p3.Value.Size = 3;
            p3.SetName("p3");
            pn.PlaceList.add(p3);

            DataCarQueue p4 = new DataCarQueue();
            p4.Value.Size = 3;
            p4.SetName("p4");
            pn.PlaceList.add(p4);

            DataCar p4n = new DataCar();
            p4n.SetName("p4n");
            pn.PlaceList.add(p4n);

            //--- DataCar

            DataCar p7 = new DataCar();
            p7.SetName("p7");
            pn.PlaceList.add(p7);

            DataCar p8 = new DataCar();
            p8.SetName("p8");
            pn.PlaceList.add(p8);

            DataCar p9 = new DataCar();
            p9.SetName("p9");
            pn.PlaceList.add(p9);

            DataCar p10 = new DataCar();
            p10.SetName("p10");
            pn.PlaceList.add(p10);

            DataCar p11 = new DataCar();
            p11.SetName("p11");
            pn.PlaceList.add(p11);

            DataCar p12 = new DataCar();
            p12.SetName("p12");
            pn.PlaceList.add(p12);

            DataCar p13 = new DataCar();
            p13.SetName("p13");
            pn.PlaceList.add(p13);

            DataCar p14 = new DataCar();
            p14.SetName("p14");
            pn.PlaceList.add(p14);

            DataCar p15 = new DataCar();
            p15.SetName("p15");
            pn.PlaceList.add(p15);

            DataCar p16 = new DataCar();
            p16.SetName("p16");
            pn.PlaceList.add(p16);

            DataTransfer p5n = new DataTransfer();
            p5n.SetName("p5n");
            p5n.Value = new TransferOperation("localhost", "1091", "p1n");
            pn.PlaceList.add(p5n);

            //--- Transitions

            //--- Transition t0

            PetriTransition t0 = new PetriTransition(pn);
            t0.TransitionName = "t0";
            t0.InputPlaceName.add("p4n");

            Condition T0Ct1 = new Condition(t0,"pt4n", TransitionCondition.NotNull);
            Condition T0Ct2 = new Condition(t0,"p1", TransitionCondition.CanAddCars);
            T0Ct1.SetNextCondition(LogicConnector.AND, T0Ct2);

            GuardMapping grdT0 = new GuardMapping();
            grdT0.condition = T0Ct1;

            grdT0.Activations.add(new Activation(t0, "p4n", TransitionOperation.AddElement,"p1"));

            t0.GuardMappingList.add(grdT0);
            t0.Delay = 0;
            pn.Transitions.add(t0);


            //--- Transition t6

            PetriTransition t6 = new PetriTransition(pn);
            t6.TransitionName = "t6";
            t6.InputPlaceName.add("p7");

            Condition T6Ct1 = new Condition(t6,"pt4n", TransitionCondition.NotNull);
            Condition T6Ct2 = new Condition(t6,"p1", TransitionCondition.CanAddCars);
            T6Ct1.SetNextCondition(LogicConnector.AND, T6Ct2);

            GuardMapping grdT6 = new GuardMapping();
            grdT6.condition = T6Ct1;

            grdT6.Activations.add(new Activation(t6, "p7", TransitionOperation.AddElement,"p1"));

            t6.GuardMappingList.add(grdT6);
            t6.Delay = 0;
            pn.Transitions.add(t6);

            //--- Transition t7

            PetriTransition t7 = new PetriTransition(pn);
            t7.TransitionName = "t7";
            t7.InputPlaceName.add("p8");

            Condition T7Ct1 = new Condition(t7,"p7", TransitionCondition.NotNull);
            Condition T7Ct2 = new Condition(t7,"p2", TransitionCondition.CanAddCars);
            T7Ct1.SetNextCondition(LogicConnector.AND, T7Ct2);

            GuardMapping grdT7 = new GuardMapping();
            grdT7.condition = T7Ct1;

            grdT7.Activations.add(new Activation(t7, "p7", TransitionOperation.AddElement,"p2"));

            t7.GuardMappingList.add(grdT7);
            t7.Delay = 0;
            pn.Transitions.add(t7);

            //--- Transition t10

            PetriTransition t10 = new PetriTransition(pn);
            t10.TransitionName = "t10";
            t10.InputPlaceName.add("p11");

            Condition T10Ct1 = new Condition(t10,"p11", TransitionCondition.NotNull);
            Condition T10Ct2 = new Condition(t10,"p2", TransitionCondition.CanAddCars);
            T10Ct1.SetNextCondition(LogicConnector.AND, T10Ct2);

            GuardMapping grdT10 = new GuardMapping();
            grdT10.condition = T10Ct1;

            grdT10.Activations.add(new Activation(t10, "p11", TransitionOperation.AddElement,"p2"));

            t10.GuardMappingList.add(grdT10);
            t10.Delay = 0;
            pn.Transitions.add(t10);

            //--- Transition t8

            PetriTransition t8 = new PetriTransition(pn);
            t8.TransitionName = "t8";
            t8.InputPlaceName.add("p9");

            Condition T8Ct1 = new Condition(t8,"p9", TransitionCondition.NotNull);
            Condition T8Ct2 = new Condition(t8,"p3", TransitionCondition.CanAddCars);
            T8Ct1.SetNextCondition(LogicConnector.AND, T8Ct2);

            GuardMapping grdT8 = new GuardMapping();
            grdT8.condition = T8Ct1;

            grdT8.Activations.add(new Activation(t8, "p9", TransitionOperation.AddElement,"p3"));

            t8.GuardMappingList.add(grdT8);
            t8.Delay = 0;
            pn.Transitions.add(t8);

            //--- Transition t11

            PetriTransition t11 = new PetriTransition(pn);
            t11.TransitionName = "t11";
            t11.InputPlaceName.add("p12");

            Condition T11Ct1 = new Condition(t11,"p12", TransitionCondition.NotNull);
            Condition T11Ct2 = new Condition(t11,"p3", TransitionCondition.CanAddCars);
            T11Ct1.SetNextCondition(LogicConnector.AND, T11Ct2);

            GuardMapping grdT11 = new GuardMapping();
            grdT11.condition = T11Ct1;

            grdT11.Activations.add(new Activation(t11, "p12", TransitionOperation.AddElement,"p3"));

            t11.GuardMappingList.add(grdT11);
            t11.Delay = 0;
            pn.Transitions.add(t11);

            //--- Transition t9

            PetriTransition t9 = new PetriTransition(pn);
            t9.TransitionName = "t9";
            t9.InputPlaceName.add("p10");

            Condition T9Ct1 = new Condition(t9,"p10", TransitionCondition.NotNull);
            Condition T9Ct2 = new Condition(t9,"p4", TransitionCondition.CanAddCars);
            T9Ct1.SetNextCondition(LogicConnector.AND, T9Ct2);

            GuardMapping grdT9 = new GuardMapping();
            grdT9.condition = T9Ct1;

            grdT9.Activations.add(new Activation(t9, "p10", TransitionOperation.AddElement,"p4"));

            t9.GuardMappingList.add(grdT9);
            t9.Delay = 0;
            pn.Transitions.add(t9);

            //--- Transition t12

            PetriTransition t12 = new PetriTransition(pn);
            t12.TransitionName = "t12";
            t12.InputPlaceName.add("p13");

            Condition T12Ct1 = new Condition(t12,"p13", TransitionCondition.NotNull);
            Condition T12Ct2 = new Condition(t12,"p4", TransitionCondition.CanAddCars);
            T12Ct1.SetNextCondition(LogicConnector.AND, T12Ct2);

            GuardMapping grdT12 = new GuardMapping();
            grdT12.condition = T12Ct1;

            grdT12.Activations.add(new Activation(t12, "p13", TransitionOperation.AddElement,"p4"));

            t12.GuardMappingList.add(grdT12);
            t12.Delay = 0;
            pn.Transitions.add(t12);

            //--- Transition t13

            PetriTransition t13 = new PetriTransition(pn);
            t13.TransitionName = "t13";
            t13.InputPlaceName.add("p2");

            Condition T13Ct1 = new Condition(t13,"p2", TransitionCondition.HaveCarForMe);

            GuardMapping grdT13 = new GuardMapping();
            grdT13.condition = T13Ct1;

            grdT13.Activations.add(new Activation(t13, "p2", TransitionOperation.PopElementWithTarget,"p14"));

            t13.GuardMappingList.add(grdT13);
            t13.Delay = 0;
            pn.Transitions.add(t13);

            //--- Transition t14

            PetriTransition t14 = new PetriTransition(pn);
            t14.TransitionName = "t14";
            t14.InputPlaceName.add("p3");

            Condition T14Ct1 = new Condition(t14,"p3", TransitionCondition.HaveCarForMe);

            GuardMapping grdT14 = new GuardMapping();
            grdT14.condition = T14Ct1;

            grdT14.Activations.add(new Activation(t14, "p3", TransitionOperation.PopElementWithTarget,"p15"));

            t14.GuardMappingList.add(grdT14);
            t14.Delay = 0;
            pn.Transitions.add(t14);

            //--- Transition t15

            PetriTransition t15 = new PetriTransition(pn);
            t15.TransitionName = "t15";
            t15.InputPlaceName.add("p4");

            Condition T15Ct1 = new Condition(t15,"p4", TransitionCondition.HaveCarForMe);

            GuardMapping grdT15 = new GuardMapping();
            grdT15.condition = T15Ct1;

            grdT15.Activations.add(new Activation(t15, "p4", TransitionOperation.PopElementWithTarget,"p16"));

            t15.GuardMappingList.add(grdT15);
            t15.Delay = 0;
            pn.Transitions.add(t15);

            //--- Transition t1

            PetriTransition t1 = new PetriTransition(pn);
            t1.TransitionName = "t1";
            t1.InputPlaceName.add("p1");

            Condition T1Ct1 = new Condition(t1,"p1", TransitionCondition.HaveCarForMe);

            GuardMapping grdT1 = new GuardMapping();
            grdT1.condition = T1Ct1;

            grdT1.Activations.add(new Activation(t1, "p1", TransitionOperation.PopElementWithTarget,"p11"));

            t1.GuardMappingList.add(grdT1);
            t1.Delay = 0;
            pn.Transitions.add(t1);

            //--- Transition t2

            PetriTransition t2 = new PetriTransition(pn);
            t2.TransitionName = "t2";
            t2.InputPlaceName.add("p2");

            Condition T2Ct1 = new Condition(t2,"p2", TransitionCondition.HaveCarForMe);

            GuardMapping grdT2 = new GuardMapping();
            grdT2.condition = T2Ct1;

            grdT2.Activations.add(new Activation(t2, "p2", TransitionOperation.PopElementWithTarget,"p12"));

            t2.GuardMappingList.add(grdT2);
            t2.Delay = 0;
            pn.Transitions.add(t2);

            //--- Transition t3

            PetriTransition t3 = new PetriTransition(pn);
            t3.TransitionName = "t3";
            t3.InputPlaceName.add("p3");

            Condition T3Ct1 = new Condition(t3,"p3", TransitionCondition.HaveCarForMe);

            GuardMapping grdT3 = new GuardMapping();
            grdT3.condition = T3Ct1;

            grdT3.Activations.add(new Activation(t3, "p3", TransitionOperation.PopElementWithTarget,"p13"));

            t3.GuardMappingList.add(grdT3);
            t3.Delay = 0;
            pn.Transitions.add(t3);

            //--- Transition t4
            
            PetriTransition t4 = new PetriTransition(pn);
            t4.TransitionName = "t4";
            t4.InputPlaceName.add("p4");
            
            Condition T4Ct1 = new Condition(t4,"p4", TransitionCondition.HaveCarForMe);
            
            GuardMapping grdT4 = new GuardMapping();
            grdT4.condition = T4Ct1;
            
            grdT4.Activations.add(new Activation(t4, "p4", TransitionOperation.PopElementWithTarget,"p5"));
            
            t4.GuardMappingList.add(grdT4);
            t4.Delay = 0;
            pn.Transitions.add(t4);

            //--- Transition t5

            PetriTransition t5 = new PetriTransition(pn);
            t5.TransitionName = "t5";
            t5.InputPlaceName.add("p5");

            Condition T4Ct1 = new Condition(t5,"p5", TransitionCondition.NotNull);

            GuardMapping grdT4 = new GuardMapping();
            grdT4.condition = T4Ct1;

            grdT4.Activations.add(new Activation(t5, "p5", TransitionOperation.SendOverNetwork,"p5n"));

            t5.GuardMappingList.add(grdT4);
            t5.Delay = 0;
            pn.Transitions.add(t5);

            // GUI
            System.out.println("Connection Street started \n ------------------------------");
            pn.Delay = 5000;

            PetriNetWindow frame = new PetriNetWindow(false);
            frame.petriNet = pn;
            frame.setVisible(true);

        }
}
