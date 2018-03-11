/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.sound.sampled.spi;		  	 

import javax.sound.sampled.Mixer;

/**
 * A provider or factory for a particular mixer type.
 * This mechanism allows the implementation to determine
 * how resources are managed in creation / management of
 * a mixer.
 *
 * @version %I% %E%
 * @author Kara Kytle
 * @since 1.3
 */
public abstract class MixerProvider {


    /**
     * Indicates whether the mixer provider supports the mixer represented by
     * the specified mixer info object.
     * @param info an info object that describes the mixer for which support is queried
     * @return <code>true</code> if the specified mixer is supported, 
     * otherwise <code>false</code>
     */
    public boolean isMixerSupported(Mixer.Info info) {

	Mixer.Info infos[] = getMixerInfo();
		
	for(int i=0; i<infos.length; i++){
	    if( info.equals( infos[i] ) ) {
		return true;
	    }
	}
	return false;
    }


    /**
     * Obtains the set of info objects representing the mixer
     * or mixers provided by this MixerProvider.
     * @return set of mixer info objects
     */
    public abstract Mixer.Info[] getMixerInfo();


    /**
     * Obtains an instance of the mixer represented by the info object.
     * @param info an info object that describes the desired mixer
     * @return mixer instance
     * @throws IllegalArgumentException if the info object specified does not
     * match the info object for a mixer supported by this MixerProvider.
     */
    public abstract Mixer getMixer(Mixer.Info info);
}
