package service;

import java.sql.SQLException;

import entity.Trip;

/**
 * ���������ӿ�
 * @author hxs
 *
 */
public interface TripService {

	public Trip findTrip(int trip_id) throws SQLException;
}
