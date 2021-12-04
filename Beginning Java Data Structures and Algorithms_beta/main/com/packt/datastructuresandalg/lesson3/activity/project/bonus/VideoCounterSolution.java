package com.packt.datastructuresandalg.lesson3.activity.project.bonus;

public class VideoCounterSolution implements Comparable<VideoCounterSolution>{
	
	private Long videoID;
	private int counter = 0;
	
	public VideoCounterSolution(Long videoID) {
		super();
		this.videoID = videoID;
	}

	public VideoCounterSolution(Long videoID, int counterStartFrom) {
		super();
		this.videoID = videoID;
		this.counter = counterStartFrom;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public void count() {
		counter ++;
	}
	
	public Long getVideoID() {
		return videoID;
	}

    /**
     * Compares two {@code VideoCounter} objects numerically
     * by counters.
     *
     * @param   otherCounter the {@code VideoCounter} to be compared.
     * @return  the value {@code 0} if this {@code Long} is
     *          equal to the argument {@code Long}; a value less than
     *          {@code 0} if this {@code Long} is numerically less
     *          than the argument {@code Long}; and a value greater
     *          than {@code 0} if this {@code Long} is numerically
     *           greater than the argument {@code Long} (signed
     *           comparison).
     */
	@Override
	public int compareTo(VideoCounterSolution otherCounter) {
		return compare(this.counter, otherCounter.getCounter());
	}
	
    /**
     * Compares two {@code long} values numerically.
     * The value returned is identical to what would be returned by:
     * <pre>
     *    Long.valueOf(x).compareTo(Long.valueOf(y))
     * </pre>
     *
     * @param  x the first {@code long} to compare
     * @param  y the second {@code long} to compare
     * @return the value {@code 0} if {@code x == y};
     *         a value less than {@code 0} if {@code x < y}; and
     *         a value greater than {@code 0} if {@code x > y}
     */
    public static int compare(long x, long y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}
