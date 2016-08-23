
package com.adp.vehicleidentifier.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Prabal Srivastava
 * @since 1.0
 */
public class VehiclesResponse implements Serializable {
	private static final long serialVersionUID = -7344504310003077249L;
	private List<VehicleDto> vehicles;
	private List<Summary> summary;
	public static class VehicleDto implements Serializable {
		private static final long serialVersionUID = 1236240377010969284L;
		private String id;
		private String frame;
		private String type;
		private String powertrain;
		private String wheels;

		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}

		/**
		 * @param id
		 *            the id to set
		 */
		public void setId(String id) {
			this.id = id;
		}

		/**
		 * @return the frame
		 */
		public String getFrame() {
			return frame;
		}

		/**
		 * @param frame
		 *            the frame to set
		 */
		public void setFrame(String frame) {
			this.frame = frame;
		}

		/**
		 * @return the type
		 */
		public String getType() {
			return type;
		}

		/**
		 * @param type
		 *            the type to set
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * @return the powertrain
		 */
		public String getPowertrain() {
			return powertrain;
		}

		/**
		 * @param powertrain
		 *            the powertrain to set
		 */
		public void setPowertrain(String powertrain) {
			this.powertrain = powertrain;
		}

		/**
		 * @return the wheels
		 */
		public String getWheels() {
			return wheels;
		}

		/**
		 * @param wheels
		 *            the wheels to set
		 */
		public void setWheels(String wheels) {
			this.wheels = wheels;
		}
	}

	public static class Summary implements Serializable {
		private static final long serialVersionUID = -6665110584407415483L;
		private String vehicleType;
		private long count;
		
		public Summary() {
			
		}
		
		public Summary(String vehicleType, long count) {
			super();
			this.vehicleType = vehicleType;
			this.count = count;
		}
		/**
		 * @return the vehicleType
		 */
		public String getVehicleType() {
			return vehicleType;
		}
		/**
		 * @param vehicleType the vehicleType to set
		 */
		public void setVehicleType(String vehicleType) {
			this.vehicleType = vehicleType;
		}
		/**
		 * @return the count
		 */
		public long getCount() {
			return count;
		}
		/**
		 * @param count the count to set
		 */
		public void setCount(long count) {
			this.count = count;
		}
		
		
	}
	/**
	 * @return the vehicles
	 */
	public List<VehicleDto> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(List<VehicleDto> vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * @return the summary
	 */
	public List<Summary> getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(List<Summary> summary) {
		this.summary = summary;
	}
}
