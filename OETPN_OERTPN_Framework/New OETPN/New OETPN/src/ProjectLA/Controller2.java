package ProjectLA;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataInteger;
import DataObjects.DataString;
import DataObjects.DataTransfer;
import DataOnly.TransferOperation;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class Controller2 {

		public static void main (String []args) {
			PetriNet pn = new PetriNet();
			pn.PetriNetName = "Controller 2";
			pn.SetName("Controller 2");
			pn.NetworkPort = 1094;
			
			DataString in0 = new DataString();
			//ini.Printable = false;
			in0.SetName("in0");
			in0.SetValue("red");
			pn.ConstantPlaceList.add(in0);
			
			DataString red = new DataString();
			//red.Printable = false;
			red.SetName("red");
			red.SetValue("red");
			pn.ConstantPlaceList.add(red);
			
			DataString green = new DataString();
			//green.Printable = false;
			green.SetName("green");
			green.SetValue("green");
			pn.ConstantPlaceList.add(green);
			
			DataString yellow = new DataString();
			//yellow.Printable = false;
			yellow.SetName("yellow");
			yellow.SetValue("yellow");
			pn.ConstantPlaceList.add(yellow);
			
			//--- Added inputs connected to OP1 of Intersection
			DataString in1 = new DataString();
			in1.SetName("in1");
			pn.PlaceList.add(in1);
			
			DataString in2 = new DataString();
			in2.SetName("in2");
			pn.PlaceList.add(in2);
			
			DataString in3 = new DataString();
			in3.SetName("in3");
			pn.PlaceList.add(in3);
			
			//----Delays
			DataInteger Five = new DataInteger();
	        Five.SetName("Five");
	        Five.SetValue(5);
	        pn.ConstantPlaceList.add(Five);
	        
	        DataInteger Ten = new DataInteger();
	        Ten.SetName("Ten");
	        Ten.SetValue(10);
	        pn.ConstantPlaceList.add(Ten);
			
            //----OP outputs
	        DataTransfer OP1 = new DataTransfer();
	        OP1.SetName("OP1");
	        OP1.Value = new TransferOperation("localhost", "1092" , "P_TL1");
			pn.PlaceList.add(OP1);
			
			DataTransfer OP2 = new DataTransfer();
			OP2.SetName("OP2");
			OP2.Value = new TransferOperation("localhost", "1092" , "P_TL2");
			pn.PlaceList.add(OP2);
			
			DataTransfer OP3 = new DataTransfer();
			OP3.SetName("OP3");
			OP3.Value = new TransferOperation("localhost", "1092" , "P_TL3");
			pn.PlaceList.add(OP3);
			
			//-------------------
			DataString r1r2r3 = new DataString();
			r1r2r3.SetName("r1r2r3");
			r1r2r3.SetValue("signal");
			pn.PlaceList.add(r1r2r3);
			
			DataString g1r2r3 = new DataString();
			g1r2r3.SetName("g1r2r3");
			pn.PlaceList.add(g1r2r3);
			
			DataString r1g2r3 = new DataString();
			r1g2r3.SetName("r1g2r3");
			pn.PlaceList.add(r1g2r3);
			
			DataString r1r2g3 = new DataString();
			r1r2g3.SetName("r1r2g3");
			pn.PlaceList.add(r1r2g3);
			
			DataString r1r2y3 = new DataString();
			r1r2y3.SetName("r1r2y3");
			pn.PlaceList.add(r1r2y3);
			
			DataString y1r2r3 = new DataString();
			y1r2r3.SetName("y1r2r3");
			pn.PlaceList.add(y1r2r3);
			
			DataString r1y2r3 = new DataString();
			r1y2r3.SetName("r1y2r3");
			pn.PlaceList.add(r1y2r3);
			
			
			//----------------------------iniT------------------------------------
			PetriTransition init = new PetriTransition(pn);
			init.TransitionName = "iniT";
			
			Condition iniTCt1 = new Condition(init, "in0", TransitionCondition.NotNull);

			GuardMapping grdiniT = new GuardMapping();
			grdiniT.condition= iniTCt1;
			
			grdiniT.Activations.add(new Activation(init, "in0", TransitionOperation.SendOverNetwork, "OP1"));
			grdiniT.Activations.add(new Activation(init, "in0", TransitionOperation.SendOverNetwork, "OP2"));
			grdiniT.Activations.add(new Activation(init, "in0", TransitionOperation.SendOverNetwork, "OP3"));
			grdiniT.Activations.add(new Activation(init, "", TransitionOperation.MakeNull, "in0"));
			
			init.GuardMappingList.add(grdiniT);
		
			init.Delay = 0;
			pn.Transitions.add(init);
			
			
			//----------------------------T1------------------------------------
			PetriTransition t1 = new PetriTransition(pn);
			t1.TransitionName = "T1";
			t1.InputPlaceName.add("g1r2r3");
			t1.InputPlaceName.add("in1");
			
			Condition T1Ct1 = new Condition(t1, "g1r2r3", TransitionCondition.NotNull);
			Condition T1Ct2 = new Condition(t1, "in1", TransitionCondition.IsNull);
			T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);
			
			GuardMapping grdT1 = new GuardMapping();
			grdT1.condition= T1Ct1;
			grdT1.Activations.add(new Activation(t1, "g1r2r3", TransitionOperation.Move, "y1r2r3"));
			grdT1.Activations.add(new Activation(t1, "yellow", TransitionOperation.SendOverNetwork, "OP1"));
		//-- Added activation of Five
			grdT1.Activations.add(new Activation(t1, "Five", TransitionOperation.DynamicDelay,""));
			
			t1.GuardMappingList.add(grdT1);
			
			Condition T1Ct3 = new Condition(t1, "g1r2r3", TransitionCondition.NotNull);
			Condition T1Ct4 = new Condition(t1, "in1", TransitionCondition.NotNull);
			T1Ct3.SetNextCondition(LogicConnector.AND, T1Ct4);
			
			GuardMapping grdT11 = new GuardMapping();
			grdT11.condition= T1Ct3;
			grdT11.Activations.add(new Activation(t1, "g1r2r3", TransitionOperation.Move, "y1r2r3"));
			grdT11.Activations.add(new Activation(t1, "yellow", TransitionOperation.SendOverNetwork, "OP1"));
		//--Added activation of Ten 
			grdT11.Activations.add(new Activation(t1, "Ten", TransitionOperation.DynamicDelay,""));
			
			t1.GuardMappingList.add(grdT11);
		
			t1.Delay = 5;
			pn.Transitions.add(t1);
			
			//----------------------------T2------------------------------------
			PetriTransition t2 = new PetriTransition(pn);
			t2.TransitionName = "T2";
			t2.InputPlaceName.add("y1r2r3");
			
			Condition T2Ct1 = new Condition(t2, "y1r2r3", TransitionCondition.NotNull);

			GuardMapping grdT2 = new GuardMapping();
			grdT2.condition= T2Ct1;
			grdT2.Activations.add(new Activation(t2, "y1r2r3", TransitionOperation.Move, "r1g2r3"));
			grdT2.Activations.add(new Activation(t2, "red", TransitionOperation.SendOverNetwork, "OP1"));
			grdT2.Activations.add(new Activation(t2, "green", TransitionOperation.SendOverNetwork, "OP2"));
					
			t2.GuardMappingList.add(grdT2);
		
			t2.Delay = 5;
			pn.Transitions.add(t2);
			
			//----------------------------T3------------------------------------
			PetriTransition t3 = new PetriTransition(pn);
			t3.TransitionName = "T3";
			t3.InputPlaceName.add("r1g2r3");
			t3.InputPlaceName.add("in2");
			
			Condition T3Ct1 = new Condition(t3, "r1g2r3", TransitionCondition.NotNull);
			Condition T3Ct2 = new Condition(t3, "in2", TransitionCondition.IsNull);
			T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);
			
			GuardMapping grdT3 = new GuardMapping();
			grdT3.condition= T3Ct1;
			grdT3.Activations.add(new Activation(t3, "r1g2r3", TransitionOperation.Move, "r1y2r3"));
			grdT3.Activations.add(new Activation(t3, "yellow", TransitionOperation.SendOverNetwork, "OP2"));
		//-- Added activation of Five
			grdT3.Activations.add(new Activation(t3, "Five", TransitionOperation.DynamicDelay,""));
			
			t3.GuardMappingList.add(grdT3);
			
			Condition T3Ct3 = new Condition(t3, "r1g2r3", TransitionCondition.NotNull);
			Condition T3Ct4 = new Condition(t3, "in2", TransitionCondition.NotNull);
			T3Ct3.SetNextCondition(LogicConnector.AND, T3Ct4);
			
			GuardMapping grdT31 = new GuardMapping();
			grdT31.condition= T3Ct3;
			grdT31.Activations.add(new Activation(t3, "r1g2r3", TransitionOperation.Move, "r1y2r3"));
			grdT31.Activations.add(new Activation(t3, "yellow", TransitionOperation.SendOverNetwork, "OP2"));
		//--Added activation of Ten 
			grdT31.Activations.add(new Activation(t3, "Ten", TransitionOperation.DynamicDelay,""));
			
			t3.GuardMappingList.add(grdT31);
		
			t3.Delay = 5;
			pn.Transitions.add(t3);
			
			
			//----------------------------T4------------------------------------
			PetriTransition t4 = new PetriTransition(pn);
			t4.TransitionName = "T4";
			t4.InputPlaceName.add("r1y2r3");
			
			Condition T4Ct1 = new Condition(t4, "r1y2r3", TransitionCondition.NotNull);

			GuardMapping grdT4 = new GuardMapping();
			grdT4.condition= T4Ct1;
			grdT4.Activations.add(new Activation(t4, "r1y2r3", TransitionOperation.Move, "r1r2g3"));
			grdT4.Activations.add(new Activation(t4, "red", TransitionOperation.SendOverNetwork, "OP2"));
			grdT4.Activations.add(new Activation(t4, "green", TransitionOperation.SendOverNetwork, "OP3"));
					
			t4.GuardMappingList.add(grdT4);
		
			t4.Delay = 5;
			pn.Transitions.add(t4);
			
			//----------------------------T5------------------------------------
			PetriTransition t5 = new PetriTransition(pn);
			t5.TransitionName = "T5";
			t5.InputPlaceName.add("r1r2g3");
			t5.InputPlaceName.add("in3");
			
			Condition T5Ct1 = new Condition(t5, "r1r2g3", TransitionCondition.NotNull);
			Condition T5Ct2 = new Condition(t5, "in3", TransitionCondition.IsNull);
			T5Ct1.SetNextCondition(LogicConnector.AND, T5Ct2);
			
			GuardMapping grdT5 = new GuardMapping();
			grdT5.condition= T5Ct1;
			grdT5.Activations.add(new Activation(t5, "r1r2g3", TransitionOperation.Move, "r1r2y3"));
			grdT5.Activations.add(new Activation(t5, "yellow", TransitionOperation.SendOverNetwork, "OP3"));
		//-- Added activation of Five
			grdT5.Activations.add(new Activation(t5, "Five", TransitionOperation.DynamicDelay,""));
			
			t5.GuardMappingList.add(grdT5);
			
			Condition T5Ct3 = new Condition(t5, "r1r2g3", TransitionCondition.NotNull);
			Condition T5Ct4 = new Condition(t5, "in3", TransitionCondition.NotNull);
			T5Ct3.SetNextCondition(LogicConnector.AND, T5Ct4);
			
			GuardMapping grdT51 = new GuardMapping();
			grdT51.condition= T5Ct3;
			grdT51.Activations.add(new Activation(t5, "r1r2g3", TransitionOperation.Move, "r1r2y3"));
			grdT51.Activations.add(new Activation(t5, "yellow", TransitionOperation.SendOverNetwork, "OP3"));
		//--Added activation of Ten 
			grdT51.Activations.add(new Activation(t5, "Ten", TransitionOperation.DynamicDelay,""));
			
			t5.GuardMappingList.add(grdT51);
		
			t5.Delay = 5;
			pn.Transitions.add(t5);
			
			
			//----------------------------T6------------------------------------
			PetriTransition t6 = new PetriTransition(pn);
			t6.TransitionName = "T6";
			t6.InputPlaceName.add("r1r2y3");
			
			Condition T6Ct1 = new Condition(t4, "r1r2y3", TransitionCondition.NotNull);

			GuardMapping grdT6 = new GuardMapping();
			grdT6.condition= T6Ct1;
			grdT6.Activations.add(new Activation(t6, "r1r2y3", TransitionOperation.Move, "r1r2r3"));
			grdT6.Activations.add(new Activation(t6, "red", TransitionOperation.SendOverNetwork, "OP3"));
			grdT6.Activations.add(new Activation(t6, "green", TransitionOperation.SendOverNetwork, "OP1"));
					
			t6.GuardMappingList.add(grdT6);
		
			t6.Delay = 5;
			pn.Transitions.add(t6);
			
			//----------------------------T7------------------------------------
			PetriTransition t7 = new PetriTransition(pn);
			t7.TransitionName = "T7";
			t7.InputPlaceName.add("r1r2r3");
			
			Condition T7Ct1 = new Condition(t7, "r1r2r3", TransitionCondition.NotNull);

			GuardMapping grdT7 = new GuardMapping();
			grdT7.condition= T7Ct1;
			grdT7.Activations.add(new Activation(t7, "r1r2r3", TransitionOperation.Move, "g1r2r3"));
			grdT7.Activations.add(new Activation(t7, "green", TransitionOperation.SendOverNetwork, "OP1"));
			t7.GuardMappingList.add(grdT7);
		
			t7.Delay = 5;
			pn.Transitions.add(t7);
			
			// -------------------------------------------------------------------------------------
			// ----------------------------PN Start-------------------------------------------------
			// -------------------------------------------------------------------------------------

			System.out.println("Controller 2 started \n ------------------------------");
			pn.Delay = 1800;
			// pn.Start();

			PetriNetWindow frame = new PetriNetWindow(false);
			frame.petriNet = pn;
			frame.setVisible(true);
		
	}
}
