package src;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
//import org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL;

public class LWJGLMain {

	// Create error callback that will print error to System.err:
	private static GLFWErrorCallback errorCallback = GLFWErrorCallback.createPrint(System.err);

	// Use key callbacks to close window if user presses esc.:
	private static GLFWKeyCallback keyCallback = new GLFWKeyCallback() {
		@Override
		public void invoke(long window, int key, int scancode, int action, int mods) {
			if ( (key == GLFW_KEY_ESCAPE) && (action == GLFW_PRESS) ) {
			glfwSetWindowShouldClose(window, true);
			}
		}
	};

	
	public static void main(String[] args) {
		
		// Set the error callback:
		glfwSetErrorCallback(errorCallback);
		
		// Initialize GLFW:
		if ( !(glfwInit()) ) {	
			throw new IllegalStateException("Unable to initialize GLFW.");
		}
	
		// Create window:
		long window = glfwCreateWindow(640, 480, "Setup_UI", 0, 0);
		if (window == 0) {	// If glfwCreateWindow failed.
			glfwTerminate();
			throw new RuntimeException("Failed to create the GLFW window.");
		}
		
		glfwSetKeyCallback(window, keyCallback);	// Register the callback to window.
		
		// Create the OpenGL context:
		glfwMakeContextCurrent(window);

		// Make the OpenGL bindings available for use by LWJGL:
		GL.createCapabilities();
		
		// Main loop to run as long as window remains open:
		while ( !(glfwWindowShouldClose(window)) ) {
			/* MAIN LOOP */
			//double time = glfwGetTime();
			
			// Swap the color buffers:
			glfwSwapBuffers(window);
			
			glfwPollEvents();
						
		}
		
		// Terminate GLFW to release resources:
		glfwDestroyWindow(window);
		keyCallback.free();
		glfwTerminate();
		errorCallback.free();
	}
}