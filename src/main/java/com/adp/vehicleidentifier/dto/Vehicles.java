package com.adp.vehicleidentifier.dto;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.*;
/**
 * @author Prabal Srivastava
 * @since 1.0
 */
@XmlRootElement(name = "vehicles")
public class Vehicles implements Serializable {
	private static final long serialVersionUID = 4355241662074567993L;
	@XmlElement(name = "vehicle")
	private List<Vehicle> vehicle;
	
	/**
	 * @return the vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicle;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicle = vehicles;
	}

	public static class Vehicle implements Serializable{
		private static final long serialVersionUID = 8077519184942980116L;
		
		private String id;
		
		private Frame frame;
		
		private Wheels wheels;
		
		private Powertrain powertrain;
		
		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the frame
		 */
		public Frame getFrame() {
			return frame;
		}

		/**
		 * @param frame the frame to set
		 */
		public void setFrame(Frame frame) {
			this.frame = frame;
		}

		/**
		 * @return the wheels
		 */
		public Wheels getWheels() {
			return wheels;
		}

		/**
		 * @param wheels the wheels to set
		 */
		public void setWheels(Wheels wheels) {
			this.wheels = wheels;
		}

		/**
		 * @return the powertrain
		 */
		public Powertrain getPowertrain() {
			return powertrain;
		}

		/**
		 * @param powertrain the powertrain to set
		 */
		public void setPowertrain(Powertrain powertrain) {
			this.powertrain = powertrain;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Vehicle [id=" + id + ", frame=" + frame + ", wheels=" + wheels + ", powertrain=" + powertrain + "]";
		}
		
	}

	public static class Frame implements Serializable{
		private static final long serialVersionUID = -2363359969030379902L;
		
		private String material;
		/**
		 * @return the material
		 */
		public String getMaterial() {
			return material;
		}
		/**
		 * @param material the material to set
		 */
		public void setMaterial(String material) {
			this.material = material;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Frame [material=" + material + "]";
		}
		
	}
	public static class Wheels implements Serializable{
		private static final long serialVersionUID = 8303408295667191507L;
		private List<Wheel> wheel;
		/**
		 * @return the wheel
		 */
		public List<Wheel> getWheel() {
			return wheel;
		}
		/**
		 * @param wheel the wheel to set
		 */
		public void setWheel(List<Wheel> wheel) {
			this.wheel = wheel;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Wheels [wheel=" + wheel + "]";
		}
		
	}
	
	public static class Wheel implements Serializable{
		private static final long serialVersionUID = -2639342287934016527L;
		
		private String position;
		
		private String material;
		
		/**
		 * @return the position
		 */
		public String getPosition() {
			return position;
		}
		/**
		 * @param position the position to set
		 */
		public void setPosition(String position) {
			this.position = position;
		}
		/**
		 * @return the material
		 */
		public String getMaterial() {
			return material;
		}
		/**
		 * @param material the material to set
		 */
		public void setMaterial(String material) {
			this.material = material;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Wheel [position=" + position + ", material=" + material + "]";
		}
		
	}
	
	
	public static class Powertrain implements Serializable{
		private static final long serialVersionUID = 4735393761821137662L;
		
		private String human;
		
		private String internalCombustion;
		
		private String bernoulli;
		/**
		 * @return the human
		 */
		public String getHuman() {
			return human;
		}
		/**
		 * @param human the human to set
		 */
		public void setHuman(String human) {
			this.human = human;
		}
		/**
		 * @return the internalCombustion
		 */
		public String getInternalCombustion() {
			return internalCombustion;
		}
		/**
		 * @param internalCombustion the internalCombustion to set
		 */
		public void setInternalCombustion(String internalCombustion) {
			this.internalCombustion = internalCombustion;
		}
		/**
		 * @return the bernoulli
		 */
		public String getBernoulli() {
			return bernoulli;
		}
		/**
		 * @param bernoulli the bernoulli to set
		 */
		public void setBernoulli(String bernoulli) {
			this.bernoulli = bernoulli;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Powertrain [human=" + human + ", internalCombustion=" + internalCombustion + ", bernoulli="
					+ bernoulli + "]";
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehicles [vehicle=" + vehicle + "]";
	}
	
	
}
