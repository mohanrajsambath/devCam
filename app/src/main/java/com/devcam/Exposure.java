/* Exposure objects represent a single photographic exposure, based on the set of parameters that
 * define one in the eyes of devCam. These include:
 * - exposure time
 * - sensitivity (ISO)
 * - aperture
 * - focal length
 * - focus distance
 *
 * Every other property of an output frame is considered an image property, not a photographic one.
 */

package com.devcam;

import android.hardware.camera2.CaptureResult;

public class Exposure {

	private Long mExposureTime;
	private Integer mSensitivity;
	private Float mAperture;
	private Float mFocalLength;
	private Float mFocusDistance;


	// - - - - - Constructors - - - - -
	public Exposure(){} // Empty constructor

	// Constructor to copy one Exposure to Another
	public Exposure(Exposure exposure){
		mExposureTime = exposure.getExposureTime();
		mSensitivity = exposure.getSensitivity();
		mAperture = exposure.getAperture();
		mFocalLength = exposure.getFocalLength();
		mFocusDistance = exposure.getFocusDistance();
	}

	// Constructor to generate an Exposure from a CaptureResult
	public Exposure(CaptureResult cr){
		mExposureTime = cr.get(CaptureResult.SENSOR_EXPOSURE_TIME);
		mSensitivity = cr.get(CaptureResult.SENSOR_SENSITIVITY);
		mAperture = cr.get(CaptureResult.LENS_APERTURE);
		mFocalLength = cr.get(CaptureResult.LENS_FOCAL_LENGTH);
		mFocusDistance = cr.get(CaptureResult.LENS_FOCUS_DISTANCE);
	}
    // - - - - -  end constructors - - - - -

    // String form just simply displays the parameters readably
    @Override
    public String toString(){
        return (mAperture<0? "Auto aperture, " : "f" + mAperture + ", ") +
               ((mExposureTime<0)? "Auto exposureTime, " : CameraReport.nsToString(mExposureTime) + ", ") +
               ((mSensitivity<0)? "Auto ISO, " : "ISO " + mSensitivity + ", ") +
               ((mFocalLength<0)? "Auto focalLength, " : mFocalLength + "mm, focus: ") +
               ((mFocusDistance<0)? "Auto focus" : CameraReport.diopterToMeters(mFocusDistance));
    }

	// - - - - - Setters and Getters - - - - -
	public Long getExposureTime() {
		return mExposureTime;
	}
	public void setExposureTime(Long mExposureTime) {
		this.mExposureTime = mExposureTime;
	}
	public Integer getSensitivity() {
		return mSensitivity;
	}
	public void setSensitivity(Integer mSensitivity) {
		this.mSensitivity = mSensitivity;
	}
	public Float getAperture() {
		return mAperture;
	}
	public void setAperture(Float mAperture) {
		this.mAperture = mAperture;
	}
	public Float getFocalLength() {
		return mFocalLength;
	}
	public void setFocalLength(Float mFocalLength) {
		this.mFocalLength = mFocalLength;
	}
	public Float getFocusDistance() {
		return mFocusDistance;
	}
	public void setFocusDistance(Float mFocusDistance) {
		this.mFocusDistance = mFocusDistance;
	}
}
