package com.headwire.aem.tooling.intellij.eclipse.stub;

/**
 * Created by schaefa on 6/18/15.
 * <p/>
 * This interface is implemented by objects that visit resource trees.
 * <p>
 * Usage:
 * <pre>
 * class Visitor implements IResourceVisitor {
 * public boolean visit(IResource res) {
 * // your code here
 * return true;
 * }
 * }
 * IResource root = ...;
 * root.accept(new Visitor());
 * </pre>
 * </p>
 * <p>
 * Clients may implement this interface.
 * </p>
 *
 * @see IResource#accept(IResourceVisitor)
 */
public interface IResourceVisitor {
    /**
     * Visits the given resource.
     *
     * @param resource the resource to visit
     * @return <code>true</code> if the resource's members should
     * be visited; <code>false</code> if they should be skipped
     * @throws CoreException if the visit fails for some reason.
     */
    public boolean visit(IResource resource) throws CoreException;
}